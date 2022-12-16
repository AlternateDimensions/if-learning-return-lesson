FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev font-manager
RUN wget https://download.jetbrains.com/fonts/JetBrainsMono-2.242.zip
RUN sudo rm -rf /var/lib/apt/lists/*
