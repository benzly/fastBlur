LOCAL_PATH		:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := bitmap2Blur
LOCAL_SRC_FILES := com_benz_fastblur_Fast2Blur.cpp
LOCAL_LDLIBS    := -lm -llog -ljnigraphics

include $(BUILD_SHARED_LIBRARY)