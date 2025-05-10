SRC_DIR = src
BIN_DIR = bin
MAIN_CLASS = Main

# Creates bin/ dir if doesn't exist
$(BIN_DIR):
	mkdir -p $(BIN_DIR)

compile: $(BIN_DIR)
	javac -d $(BIN_DIR) $(SRC_DIR)/*.java

run: compile
	java -cp $(BIN_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BIN_DIR)

check:
	java -Xlint $(SRC_DIR)/*.java
