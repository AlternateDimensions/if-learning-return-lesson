FROM gitpod/workspace-full-vnc
COPY ./JetBrainsMono[wght].ttf ./
RUN mkdir -p /home/gitpod/.fonts/
RUN install -m644 JetBrainsMono[wght].ttf /home/gitpod/.fonts/
RUN rm ./JetBrainsMono[wght].ttf
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev && \
    sudo rm -rf /var/lib/apt/lists/*

