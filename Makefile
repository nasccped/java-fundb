CC=javac
RC=java
SRC=./src
PKGS=$(SRC) $(SRC)/repl $(SRC)/database/command $(SRC)/regexing $(SRC)/token $(SRC)/exception
FILES=$(foreach pkg,$(PKGS),$(wildcard $(pkg)/*.java))
DEST=./target
MAIN=fundb/Main

build: $(FILES)
	$(CC) $^ -d $(DEST)

run: $(DEST)/$(MAIN).class
	$(RC) --class-path $(DEST) $(MAIN)

clean: $(DEST)
	rm -rf $<
