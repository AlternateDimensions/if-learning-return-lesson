FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev font-manager
RUN wget https://download.jetbrains.com/fonts/JetBrainsMono-2.242.zip
RUN unzip JetBrainsMono-2.242.zip -O ~/Downloads/JetBrainsMono
RUN mv JetBrainsMono-*.ttf ~/.local/share/fonts/
RUN fc-cache -f -v
RUN sudo apt-get install fonts-jetbrains-mono
RUN sudo rm -rf /var/lib/apt/lists/*
