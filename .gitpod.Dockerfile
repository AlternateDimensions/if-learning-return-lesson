# Creates a Docker container that allows a web-based IDE (Gitpod) to display native applications.
# Also installs JetBrains Mono font because I like it. Go ligatures!

FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev font-manager
RUN mkdir ~/.fonts
RUN mkdir ~/Downloads
RUN mkdir ~/Downloads/JetBrainsMono
RUN wget https://download.jetbrains.com/fonts/JetBrainsMono-2.242.zip
RUN unzip ~/JetBrainsMono-2.242.zip -d ~/Downloads/JetBrainsMono
RUN mv ~/Downloads/JetBrainsMono/fonts/variable/JetBrainsMono[wght].ttf ~/.fonts
RUN rm ~/JetBrainsMono-2.242.zip
RUN rm -r ~/Downloads/JetBrainsMono/
RUN sudo rm -rf /var/lib/apt/lists/*
