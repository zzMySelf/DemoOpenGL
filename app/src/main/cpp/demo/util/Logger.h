//
// Created by zhangyelei on 2024/1/25.
//

#ifndef DEMOOPENGL_LOGGER_H
#define DEMOOPENGL_LOGGER_H


class Logger {
public:
    static void e(const char* tag, const char* message);

    static void w(const char* tag,const char* message);

    static void i(const char* tag,const char* message);

    static void d(const char* tag,const char* message);

    static void v(const char* tag,const char* message);
};


#endif //DEMOOPENGL_LOGGER_H
