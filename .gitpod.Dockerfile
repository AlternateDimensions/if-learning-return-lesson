FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev
RUN wget -0 ~/Downloads "https://download.jetbrains.com/fonts/JetBrainsMono-2.242.zip" && \
    unzip ~/Downloads/JetBrainsMono-2.242.zip -o ~/Downloads/JetBrainsMono
RUN sudo apt-get install -y font-manager && \
    sudo rm -rf /var/lib/apt/lists/*

