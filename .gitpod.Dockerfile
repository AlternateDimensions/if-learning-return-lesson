FROM gitpod/workspace-full-vnc
COPY /JetBrainsMono[wght].ttf /home/gitpod/.fonts
RUN mkdir /home/gitpod/.fonts/
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev
RUN fc-cache -f -v
RUN rm ./JetBrainsMono[wght].ttf
RUN sudo rm -rf /var/lib/apt/lists/*
