CC=javac
RC=java
SRC=./src
PKGS=$(SRC)
FILES=$(foreach pkg,$(PKGS),$(wildcard $(pkg)/*.java))
DEST=./target
MAIN=Main

build: $(FILES)
	$(CC) $^ -d $(DEST)

run: $(DEST)/$(MAIN).class
	$(RC) --class-path $(DEST) $(MAIN)

clean: $(DEST)
	rm -rf $<
