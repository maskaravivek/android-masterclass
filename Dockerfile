FROM docker pull mingc/android-build-box:latest as builder
WORKDIR /app
COPY ./ ./
RUN ./gradlew build --no-daemon

FROM docker pull mingc/android-build-box:latest
COPY --from=builder /root/.gradle /root/.gradle