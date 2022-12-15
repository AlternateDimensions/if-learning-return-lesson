FROM gitpod/workspace-full-vnc
COPY ./JetBrainsMono[wght].ttf ./
RUN mkdir /home/gitpod/.fonts/
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev
RUN sudo mkdir /home/gitpod/Downloads && \
    sudo mkdir /home/gitpod/Downloads/JetBrainsMono
RUN install JetBrainsMono[wght].ttf /home/gitpod/.fonts/
RUN rm ./JetBrainsMono[wght].fonts
RUN sudo rm -rf /var/lib/apt/lists/*
