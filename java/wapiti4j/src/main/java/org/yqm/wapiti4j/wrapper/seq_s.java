/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.yqm.wapiti4j.wrapper;

public class seq_s {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected seq_s(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(seq_s obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pywapitiJNI.delete_seq_s(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setLen(long value) {
    pywapitiJNI.seq_s_len_set(swigCPtr, this, value);
  }

  public long getLen() {
    return pywapitiJNI.seq_s_len_get(swigCPtr, this);
  }

  public void setRaw(SWIGTYPE_p_unsigned_long value) {
    pywapitiJNI.seq_s_raw_set(swigCPtr, this, SWIGTYPE_p_unsigned_long.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_long getRaw() {
    long cPtr = pywapitiJNI.seq_s_raw_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_long(cPtr, false);
  }

  public seq_s_pos getPos() {
    long cPtr = pywapitiJNI.seq_s_pos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new seq_s_pos(cPtr, false);
  }

  public seq_s() {
    this(pywapitiJNI.new_seq_s(), true);
  }

}
