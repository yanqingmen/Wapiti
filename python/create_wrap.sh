echo "create wrapper code"
swig -python wapiti.i
cd ../; make python; cd python