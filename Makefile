.DEFAULT_GOAL := vscode-run

OUTPUT := $(CURDIR)/sittuccine-theme.vsix

.PHONY: vscode-build
vscode-build:
	@cd vscode && vsce package -o ${OUTPUT}

.PHONY: vscode-install
vscode-install:
	code --install-extension ${OUTPUT}

.PHONY: vscode-restart
vscode-restart:
	osascript -e 'quit app "Visual Studio Code"' && \
	sleep 3 && \
	open -a "Visual Studio Code"

.PHONY: vscode-run
vscode-run: build install restart
