LOCAL_PATH		:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE    := jpeg-6b_static

LOCAL_C_INCLUDES := \
        $(LOCAL_PATH)/ \

LOCAL_EXPORT_C_INCLUDES := \
		$(LOCAL_PATH)/ \
LOCAL_CFLAGS := $(LOCAL_C_INCLUDES:%=-I%)
LOCAL_CFLAGS += -DANDROID_NDK

LOCAL_ARM_MODE := arm

LOCAL_ASMFLAGS += -DELF

LOCAL_SRC_FILES += \
	ansi2knr.c \
	cdjpeg.c \
	cjpeg.c \
	ckconfig.c \
	djpeg.c \
	example.c \
	jcapimin.c \
	jcapistd.c \
	jccoefct.c \
	jccolor.c \
	jcdctmgr.c \
	jchuff.c \
	jcinit.c \
	jcmainct.c \
	jcmarker.c \
	jcmaster.c \
	jcomapi.c \
	jcparam.c \
	jcphuff.c \
	jcprepct.c \
	jcsample.c \
	jctrans.c \
	jdapimin.c \
	jdapistd.c \
	jdatadst.c \
	jdatasrc.c \
	jdcoefct.c \
	jdcolor.c \
	jddctmgr.c \
	jdhuff.c \
	jdinput.c \
	jdmainct.c \
	jdmarker.c \
	jdmaster.c \
	jdmerge.c \
	jdphuff.c \
	jdpostct.c \
	jdsample.c \
	jdtrans.c \
	jerror.c \
	jfdctflt.c \
	jfdctfst.c \
	jfdctint.c \
	jidctflt.c \
	jidctfst.c \
	jidctint.c \
	jidctred.c \
	jmemansi.c \
	jmemdos.c \
	jmemmac.c \
	jmemmgr.c \
	jmemname.c \
	jmemnobs.c \
	jpegtran.c \
	jquant1.c \
	jquant2.c \
	jutils.c \
	rdbmp.c \
	rdcolmap.c \
	rdgif.c \
	rdjpgcom.c \
	rdppm.c \
	rdrle.c \
	rdswitch.c \
	rdtarga.c \
	transupp.c \
	wrbmp.c \
	wrgif.c \
	wrjpgcom.c \
	wrppm.c \
	wrrle.c \
	wrtarga.c \

include $(BUILD_STATIC_LIBRARY)
