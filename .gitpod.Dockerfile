FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev
RUN sudo apt-get install fonts-jetbrains-mono (2.225+ds-1)
RUN sudo rm -rf /var/lib/apt/lists/*
