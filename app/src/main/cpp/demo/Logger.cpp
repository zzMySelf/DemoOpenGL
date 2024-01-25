//
// Created by zhangyelei on 2024/1/25.
//

#include "Logger.h"
#include <android/log.h>

void Logger::e(const char *tag, const char *message) {
    __android_log_print(ANDROID_LOG_ERROR, tag, "%s", message);
}

void Logger::w(const char *tag, const char *message) {
    __android_log_print(ANDROID_LOG_WARN, tag, "%s", message);
}

void Logger::i(const char *tag, const char *message) {
    __android_log_print(ANDROID_LOG_INFO, tag, "%s", message);
}

void Logger::d(const char *tag, const char *message) {
    __android_log_print(ANDROID_LOG_DEBUG, tag, "%s", message);
}

void Logger::v(const char *tag, const char *message) {
    __android_log_print(ANDROID_LOG_VERBOSE, tag, "%s", message);
}
