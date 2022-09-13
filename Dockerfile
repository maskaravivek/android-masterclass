FROM educative1/abdullah_flutter_cache
RUN wget --quiet -O sdk.install.sh "https://get.sdkman.io" && \
    bash -c "bash ./sdk.install.sh > /dev/null && source ~/.sdkman/bin/sdkman-init.sh && sdk install kotlin 1.5.1 && sdk install java 11.0.2-open && sdk install gradle 7.4.2" && \
    rm -f sdk.install.sh

RUN mkdir -p /tmp/educative

WORKDIR /tmp/educative
COPY ./ ./
RUN gradle tasks --configuration-cache && gradle assembleDebug --configuration-cache