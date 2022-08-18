FROM maskaravivek/android-masterclass-cache:latest
WORKDIR /app
COPY ./ ./
RUN ./gradlew build --no-daemon