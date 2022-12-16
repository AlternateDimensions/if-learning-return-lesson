FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev
RUN sudo apt-get install fonts-jetbrains-mono (2.242+ds-2) [multiverse]
RUN sudo rm -rf /var/lib/apt/lists/*
