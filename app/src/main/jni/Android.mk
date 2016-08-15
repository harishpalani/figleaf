LOCAL_PATH := $(call my-dir)

LOCAL_MODULE := libjpeg
LOCAL_SRC_FILES := ../../../prebuild/libjpeg.a
LOCAL_EXPORT_C_INCLUDES := ../../../prebuild/include
LOCAL_ALLOW_UNDEFINED_SYMBOLS := true
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_C_INCLUDES += ../../../prebuild/include
LOCAL_MODULE    := figleaf
LOCAL_SRC_FILES := figleaf.c
LOCAL_STATIC_LIBRARIES := libjpeg
LOCAL_ALLOW_UNDEFINED_SYMBOLS := true
include $(BUILD_SHARED_LIBRARY)