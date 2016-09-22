CFLAGS =-std=c99 -W -Wall -Wextra -O3 -fPIC
LIBS   =-lm -lpthread

DESTDIR=
PREFIX =/usr/local

INSTALL= install -p
INSTALL_EXEC= $(INSTALL) -m 0755
INSTALL_DATA= $(INSTALL) -m 0644

SRC=src/*.c
HDR=src/*.h
# python include path
PYTHON_INC=/usr/include/python2.7/

wapiti: $(SRC) $(HDR)
	@echo "CC: wapiti.c --> wapiti"
	@$(CC) -DNDEBUG $(CFLAGS) -o wapiti $(SRC) $(LIBS)

debug: $(SRC) $(HDR)
	@echo "CC: wapiti.c --> wapiti"
	@$(CC) -g $(CFLAGS) -o wapiti $(SRC) $(LIBS)

install: wapiti
	@echo "CP: wapiti   --> $(DESTDIR)$(PREFIX)/bin"
	@mkdir -p $(DESTDIR)$(PREFIX)/bin
	@mkdir -p $(DESTDIR)$(PREFIX)/share/man/man1
	@$(INSTALL_EXEC) wapiti       $(DESTDIR)$(PREFIX)/bin
	@$(INSTALL_DATA) doc/wapiti.1 $(DESTDIR)$(PREFIX)/share/man/man1

python: ./python/_pywapiti.so
	
./python/_pywapiti.so: $(SRC) $(HDR) ./python/wapiti_wrap.c 
	@$(CC) -DNDEBUG $(CFLAGS) -shared -o ./python/_pywapiti.so -I${PYTHON_INC} $(SRC) ./python/wapiti_wrap.c $(LIBS)


clean:
	@echo "RM: wapiti"
	@rm -f wapiti

.PHONY: clean install
