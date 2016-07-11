LOCAL_PATH	:= $(call my-dir)
include $(CLEAR_VARS)

CFLAGS := -Werror

LOCAL_C_INCLUDES := \
		$(LOCAL_PATH)/ \
		$(LOCAL_PATH)/../ \
		$(LOCAL_PATH)/../rapidjson/include \

LOCAL_CFLAGS := $(LOCAL_C_INCLUDES:%=-I%)
LOCAL_CFLAGS += -DANDROID_NDK
LOCAL_CFLAGS += -DLOG_NDEBUG
LOCAL_CFLAGS += -DACCESS_RAW_DESCRIPTORS
LOCAL_CFLAGS += -O3 -fstrict-aliasing -fprefetch-loop-arrays

LOCAL_LDLIBS := -L$(SYSROOT)/usr/lib -ldl
LOCAL_LDLIBS += -llog
LOCAL_LDLIBS += -landroid

LOCAL_SHARED_LIBRARIES += usb100 uvc

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := \
		_onload.cpp \
		utilbase.cpp \
		UVCCamera.cpp \
		UVCPreview.cpp \
		UVCButtonCallback.cpp \
		UVCStatusCallback.cpp \
		Parameters.cpp \
		serenegiant_usb_UVCCamera.cpp

LOCAL_MODULE    := Figleaf
include $(BUILD_SHARED_LIBRARY)