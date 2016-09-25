echo "create wrapper code"
swig -python -o ./wapiti_wrap.c -outdir ./ ../swig/wapiti.i
cd ../; make python; cd python