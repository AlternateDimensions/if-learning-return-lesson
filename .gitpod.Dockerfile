FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev font-manager
RUN mkdir ~/Downloads
RUN mkdir ~/Downloads/JetBrainsMono
RUN wget -O ~/Downloads https://download.jetbrains.com/fonts/JetBrainsMono-2.242.zip
RUN unzip ~/Downloads/JetBrainsMono-*.zip -d ~/Downloads/JetBrainsMono
RUN sudo rm -rf /var/lib/apt/lists/*
