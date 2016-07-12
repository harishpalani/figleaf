LOCAL_PATH := $(call my-dir)

LOCAL_MODULE := libjpeg
LOCAL_SRC_FILES := ../../../prebuild/libjpeg.a
LOCAL_EXPORT_C_INCLUDES := ../../../prebuild/include
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_C_INCLUDES += ../../../prebuild/include
LOCAL_MODULE    := figleaf
LOCAL_SRC_FILES := figleaf.cpp
LOCAL_STATIC_LIBRARIES := libjpeg

include $(BUILD_SHARED_LIBRARY)