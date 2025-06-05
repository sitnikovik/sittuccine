.PHONY: build restart run
.DEFAULT_GOAL := run

OUTPUT := $(CURDIR)/sittuccine-theme.vsix

build:
	vsce package -o ${OUTPUT}

install:
	code --install-extension ${OUTPUT}

restart:
	osascript -e 'quit app "Visual Studio Code"' && \
	sleep 3 && \
	open -a "Visual Studio Code"

run: build install restart