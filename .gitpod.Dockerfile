FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev
RUN sudo mkdir /home/gitpod/Downloads && \
    sudo mkdir /home/gitpod/Downloads/JetBrainsMono
RUN wget -O ~/Downloads https://download.jetbrains.com/fonts/JetBrainsMono-2.242.zip
RUN unzip ~/Downloads/JetBrainsMono-2.242.zip -o ~/Downloads/JetBrainsMono
RUN sudo rm -rf /var/lib/apt/lists/*
