LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE            := figleaf-prebuilt
LOCAL_SRC_FILES         := libfigleaf.so
LOCAL_EXPORT_C_INCLUDES := $(LOCAL_PATH)/../figleaf

include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := ndk
LOCAL_C_INCLUDES := $(LOCAL_PATH) \
                    $(LOCAL_PATH)/../figleaf
LOCAL_SRC_FILES := figleaf.c

LOCAL_LDLIBS := -llog
LOCAL_STATIC_LIBRARIES := figleaf-prebuilt

include $(BUILD_SHARED_LIBRARY)