FROM gitpod/workspace-full-vnc
RUN sudo apt-get update
RUN sudo apt-get install -y apt-transport-https
RUN sudo apt-get install -y libgtk-3-dev
RUN sudo apt-get install -y font-manager
RUN sudo apt-get install -y fonts-jetbrains-mono
RUN sudo rm -rf /var/lib/apt/lists/*
