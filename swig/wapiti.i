%module pywapiti
%{
#include "../src/decoder.h"
#include "../src/model.h"
#include "../src/options.h"
#include "../src/progress.h"
#include "../src/quark.h"
#include "../src/reader.h"
#include "../src/sequence.h"
#include "../src/tools.h"
#include "../src/trainers.h"  
typedef unsigned int        uint32_t;
typedef unsigned long int	uint64_t;
%}

typedef unsigned int        uint32_t;
typedef unsigned long int	uint64_t;
void tag_label(mdl_t *mdl, FILE *fin, FILE *fout);
void tag_seq(mdl_t *mdl, fancy_raw_t *raw_seq,  fancy_raw_t *tag_seq);
%include "../src/model.h"
%include "../src/options.h"
%include "../src/progress.h"
%include "../src/quark.h"
%include "../src/reader.h"
%include "../src/sequence.h"
%include "../src/tools.h"
%include "../src/trainers.h"