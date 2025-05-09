# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)

# Declares and names the project.

project("demoopengl")

set(OPENCV_LIBS_DIR ${CMAKE_SOURCE_DIR}/../opencv_include)
set(OPENCV_LIBS ${CMAKE_SOURCE_DIR}/../opencv_lib)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

include_directories(
        demo
        demo/glm
        ${OPENCV_LIBS_DIR}
)
file(GLOB CPP_SOURCES
        demo/*.cpp
        demo/util/*.cpp
        demo/sample/*.cpp
        )

add_library( # Sets the name of the library.
        demoopengl

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        native-lib.cpp

        ${CPP_SOURCES}
        )

add_library(libopencv_java4 SHARED IMPORTED)
set_target_properties(libopencv_java4 PROPERTIES IMPORTED_LOCATION
        ${OPENCV_LIBS}/${ANDROID_ABI}/libopencv_java4.so)


# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        demoopengl

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}

        EGL
        GLESv3
        android

        jnigraphics
        libopencv_java4
        )