FROM gitpod/workspace-full-vnc
RUN sudo apt-get update && \
    sudo apt-get install -y libgtk-3-dev font-manager
RUN mkdir ~/.fonts
RUN mkdir ~/JetBrainsMono
RUN wget https://download.jetbrains.com/fonts/JetBrainsMono-2.242.zip
RUN unzip ~/JetBrainsMono-2.242.zip -d ~/JetBrainsMono
RUN mv ~/JetBrainsMono/fonts/variable/JetBrainsMono[wght].ttf ~/.fonts
RUN rm ~/JetBrainsMono-2.242.zip
RUN rm ~/JetBrainsMono
RUN sudo rm -rf /var/lib/apt/lists/*
