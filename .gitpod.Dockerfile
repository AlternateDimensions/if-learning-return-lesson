FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev && \
    sudo apt-get install -y font-manager && \
    sudo apt-get install -y fonts-jetbrains-mono && \
    sudo rm -rf /var/lib/apt/lists/*
