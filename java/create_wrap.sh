wrapper_path=wapiti4j/src/main/java/org/yqm/wapiti4j/wrapper
native_path=wapiti4j/src/main/resources/lib/native

rm ${wrapper_path}/*.java ${native_path}/libwapiti4j.so
echo 'swig -java -package org.yqm.wapiti4j.wrapper -o ./wapiti_wrap.c -outdir=./ ../swig/wapiti.i'
swig -java -package org.yqm.wapiti4j.wrapper -o ./wapiti_wrap.c -outdir ./ ../swig/wapiti.i
mkdir -p ${wrapper_path}
mv *.java ${wrapper_path}/

echo 'build wrapper'
cd ..
make java
cd java
mkdir -p ${native_path}
mv libwapiti4j.so ${native_path}

echo 'complete'