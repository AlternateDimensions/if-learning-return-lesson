FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev font-manager
RUN mkdir ~/.fonts
RUN mkdir ~/JetBrainsMono
RUN wget https://download.jetbrains.com/fonts/JetBrainsMono-2.242.zip
RUN unzip ~/Downloads/JetBrainsMono-*.zip -d ~/JetBrainsMono
RUN mv ~/JetBrainsMono/JetBrainsMono-*.ttf ~/.fonts
RUN rm ~/JetBrainsMono-*.zip
RUN rm ~/JetBrainsMono
RUN sudo rm -rf /var/lib/apt/lists/*
