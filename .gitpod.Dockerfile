FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev
RUN sudo apt-get install ttf-jetbrains-mono 2.242-2
RUN sudo rm -rf /var/lib/apt/lists/*
