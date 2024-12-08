.PHONY: build restart run
.DEFAULT_GOAL := run

build:
	vsce package && \
	code --install-extension /Users/sitnikovik/github/sit-monokai-theme/sittuccine-theme-1.0.0.vsix

restart:
	osascript -e 'quit app "Visual Studio Code"' && \
	sleep 3 && \
	open -a "Visual Studio Code"

run: build restart