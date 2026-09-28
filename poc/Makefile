# Compiler and flags
KC = kotlinc
KC_FLAGS = -include-runtime

# Target binary name and sources
TARGET = Main.jar
SOURCES = Main.kt

.PHONY: all clean

# Default rule: builds the JAR without running it
all: $(TARGET)

$(TARGET): $(SOURCES)
	$(KC) $(SOURCES) $(KC_FLAGS) -d $(TARGET)

# Remove build artifacts
clean:
	rm -f $(TARGET)