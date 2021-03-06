/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.yqm.wapiti4j.wrapper;

public class opt_s {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected opt_s(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(opt_s obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pywapitiJNI.delete_opt_s(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setMode(int value) {
    pywapitiJNI.opt_s_mode_set(swigCPtr, this, value);
  }

  public int getMode() {
    return pywapitiJNI.opt_s_mode_get(swigCPtr, this);
  }

  public void setInput(String value) {
    pywapitiJNI.opt_s_input_set(swigCPtr, this, value);
  }

  public String getInput() {
    return pywapitiJNI.opt_s_input_get(swigCPtr, this);
  }

  public void setOutput(String value) {
    pywapitiJNI.opt_s_output_set(swigCPtr, this, value);
  }

  public String getOutput() {
    return pywapitiJNI.opt_s_output_get(swigCPtr, this);
  }

  public void setMaxent(boolean value) {
    pywapitiJNI.opt_s_maxent_set(swigCPtr, this, value);
  }

  public boolean getMaxent() {
    return pywapitiJNI.opt_s_maxent_get(swigCPtr, this);
  }

  public void setType(String value) {
    pywapitiJNI.opt_s_type_set(swigCPtr, this, value);
  }

  public String getType() {
    return pywapitiJNI.opt_s_type_get(swigCPtr, this);
  }

  public void setAlgo(String value) {
    pywapitiJNI.opt_s_algo_set(swigCPtr, this, value);
  }

  public String getAlgo() {
    return pywapitiJNI.opt_s_algo_get(swigCPtr, this);
  }

  public void setPattern(String value) {
    pywapitiJNI.opt_s_pattern_set(swigCPtr, this, value);
  }

  public String getPattern() {
    return pywapitiJNI.opt_s_pattern_get(swigCPtr, this);
  }

  public void setModel(String value) {
    pywapitiJNI.opt_s_model_set(swigCPtr, this, value);
  }

  public String getModel() {
    return pywapitiJNI.opt_s_model_get(swigCPtr, this);
  }

  public void setDevel(String value) {
    pywapitiJNI.opt_s_devel_set(swigCPtr, this, value);
  }

  public String getDevel() {
    return pywapitiJNI.opt_s_devel_get(swigCPtr, this);
  }

  public void setRstate(String value) {
    pywapitiJNI.opt_s_rstate_set(swigCPtr, this, value);
  }

  public String getRstate() {
    return pywapitiJNI.opt_s_rstate_get(swigCPtr, this);
  }

  public void setSstate(String value) {
    pywapitiJNI.opt_s_sstate_set(swigCPtr, this, value);
  }

  public String getSstate() {
    return pywapitiJNI.opt_s_sstate_get(swigCPtr, this);
  }

  public void setCompact(boolean value) {
    pywapitiJNI.opt_s_compact_set(swigCPtr, this, value);
  }

  public boolean getCompact() {
    return pywapitiJNI.opt_s_compact_get(swigCPtr, this);
  }

  public void setSparse(boolean value) {
    pywapitiJNI.opt_s_sparse_set(swigCPtr, this, value);
  }

  public boolean getSparse() {
    return pywapitiJNI.opt_s_sparse_get(swigCPtr, this);
  }

  public void setNthread(long value) {
    pywapitiJNI.opt_s_nthread_set(swigCPtr, this, value);
  }

  public long getNthread() {
    return pywapitiJNI.opt_s_nthread_get(swigCPtr, this);
  }

  public void setJobsize(long value) {
    pywapitiJNI.opt_s_jobsize_set(swigCPtr, this, value);
  }

  public long getJobsize() {
    return pywapitiJNI.opt_s_jobsize_get(swigCPtr, this);
  }

  public void setMaxiter(long value) {
    pywapitiJNI.opt_s_maxiter_set(swigCPtr, this, value);
  }

  public long getMaxiter() {
    return pywapitiJNI.opt_s_maxiter_get(swigCPtr, this);
  }

  public void setRho1(double value) {
    pywapitiJNI.opt_s_rho1_set(swigCPtr, this, value);
  }

  public double getRho1() {
    return pywapitiJNI.opt_s_rho1_get(swigCPtr, this);
  }

  public void setRho2(double value) {
    pywapitiJNI.opt_s_rho2_set(swigCPtr, this, value);
  }

  public double getRho2() {
    return pywapitiJNI.opt_s_rho2_get(swigCPtr, this);
  }

  public void setObjwin(long value) {
    pywapitiJNI.opt_s_objwin_set(swigCPtr, this, value);
  }

  public long getObjwin() {
    return pywapitiJNI.opt_s_objwin_get(swigCPtr, this);
  }

  public void setStopwin(long value) {
    pywapitiJNI.opt_s_stopwin_set(swigCPtr, this, value);
  }

  public long getStopwin() {
    return pywapitiJNI.opt_s_stopwin_get(swigCPtr, this);
  }

  public void setStopeps(double value) {
    pywapitiJNI.opt_s_stopeps_set(swigCPtr, this, value);
  }

  public double getStopeps() {
    return pywapitiJNI.opt_s_stopeps_get(swigCPtr, this);
  }

  public void setLabel(boolean value) {
    pywapitiJNI.opt_s_label_set(swigCPtr, this, value);
  }

  public boolean getLabel() {
    return pywapitiJNI.opt_s_label_get(swigCPtr, this);
  }

  public void setCheck(boolean value) {
    pywapitiJNI.opt_s_check_set(swigCPtr, this, value);
  }

  public boolean getCheck() {
    return pywapitiJNI.opt_s_check_get(swigCPtr, this);
  }

  public void setOutsc(boolean value) {
    pywapitiJNI.opt_s_outsc_set(swigCPtr, this, value);
  }

  public boolean getOutsc() {
    return pywapitiJNI.opt_s_outsc_get(swigCPtr, this);
  }

  public void setLblpost(boolean value) {
    pywapitiJNI.opt_s_lblpost_set(swigCPtr, this, value);
  }

  public boolean getLblpost() {
    return pywapitiJNI.opt_s_lblpost_get(swigCPtr, this);
  }

  public void setNbest(long value) {
    pywapitiJNI.opt_s_nbest_set(swigCPtr, this, value);
  }

  public long getNbest() {
    return pywapitiJNI.opt_s_nbest_get(swigCPtr, this);
  }

  public void setForce(boolean value) {
    pywapitiJNI.opt_s_force_set(swigCPtr, this, value);
  }

  public boolean getForce() {
    return pywapitiJNI.opt_s_force_get(swigCPtr, this);
  }

  public void setPrec(int value) {
    pywapitiJNI.opt_s_prec_set(swigCPtr, this, value);
  }

  public int getPrec() {
    return pywapitiJNI.opt_s_prec_get(swigCPtr, this);
  }

  public void setAll(boolean value) {
    pywapitiJNI.opt_s_all_set(swigCPtr, this, value);
  }

  public boolean getAll() {
    return pywapitiJNI.opt_s_all_get(swigCPtr, this);
  }

  public opt_s_lbfgs getLbfgs() {
    long cPtr = pywapitiJNI.opt_s_lbfgs_get(swigCPtr, this);
    return (cPtr == 0) ? null : new opt_s_lbfgs(cPtr, false);
  }

  public opt_s_sgdl1 getSgdl1() {
    long cPtr = pywapitiJNI.opt_s_sgdl1_get(swigCPtr, this);
    return (cPtr == 0) ? null : new opt_s_sgdl1(cPtr, false);
  }

  public opt_s_bcd getBcd() {
    long cPtr = pywapitiJNI.opt_s_bcd_get(swigCPtr, this);
    return (cPtr == 0) ? null : new opt_s_bcd(cPtr, false);
  }

  public opt_s_rprop getRprop() {
    long cPtr = pywapitiJNI.opt_s_rprop_get(swigCPtr, this);
    return (cPtr == 0) ? null : new opt_s_rprop(cPtr, false);
  }

  public opt_s() {
    this(pywapitiJNI.new_opt_s(), true);
  }

}
