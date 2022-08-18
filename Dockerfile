FROM openjdk:8

WORKDIR /

SHELL ["/bin/sh", "-c"]

RUN apt-get update --yes --allow-unauthenticated && apt-get upgrade --yes --allow-unauthenticated && apt-get --yes --allow-unauthenticated install bash git unzip wget qemu-utils libvirt-daemon dbus virt-manager

# gradle caching
ENV GRADLE_USER_HOME=/cache
VOLUME $GRADLE_USER_HOME

# android pre-installed sdk tools/libs
ARG ANDROID_VERSION="android-32"
ARG ANDROID_PLATFORM_VERSION="platforms;${ANDROID_VERSION}"
ARG ANDROID_SDK_VERSION="sdk-tools-linux-4333796.zip"
ARG ANDROID_SDK_PACKAGES_EXTRA=""
ARG ANDROID_SDK_PACKAGES="${ANDROID_PLATFORM_VERSION} platform-tools ${ANDROID_SDK_PACKAGES_EXTRA}"

RUN wget https://dl.google.com/android/repository/${ANDROID_SDK_VERSION} -P /tmp && \
    unzip -d /opt/android /tmp/${ANDROID_SDK_VERSION}
ENV ANDROID_HOME=/opt/android
ENV PATH "$PATH:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools"

# sdkmanager
RUN mkdir /root/.android/
RUN touch /root/.android/repositories.cfg
RUN yes Y | sdkmanager --licenses 
RUN yes Y | sdkmanager --verbose --no_https ${ANDROID_SDK_PACKAGES}

WORKDIR /app
COPY ./ ./
RUN ./gradlew clean build --no-daemon