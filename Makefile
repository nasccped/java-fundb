CC=javac
RC=java
SRC=./src
# packages bellow are organized with indent spaces
PKGS=$(SRC) \
	 	$(SRC)/database \
	 	$(SRC)/regex \
	 	$(SRC)/repl \
	 		$(SRC)/repl/evaluator \
	 		$(SRC)/repl/printer \
	 		$(SRC)/repl/reader \
	 	$(SRC)/tokens \
	 		$(SRC)/tokens/definition \
	 		$(SRC)/tokens/factory \
	 		$(SRC)/tokens/variants \
	 		$(SRC)/tokens/kind
FILES=$(foreach pkg,$(PKGS),$(wildcard $(pkg)/*.java))
DEST=./target
MAIN=fundb/Main

build: $(FILES)
	$(CC) $^ -d $(DEST)

run: $(DEST)/$(MAIN).class
	$(RC) --class-path $(DEST) $(MAIN)

clean: $(DEST)
	rm -rf $<
