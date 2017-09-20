public class Job {
    private int id, submitTime, CPUTime, CPUTimeLeft;
    
    private int startTime = 0, endTime = 0;
    
    public int ProcessCompletionTime;
    public int processArrivalTime;
    public int waitingTime;
    public int turnAroundTime;
    private JobFinishEvent evt;
    
    // global variables
    private int arrivalTime, cpuTime, processId;
    
    public Job(int id, int submitTime, int CPUTime) {
        super();
        this.id             = id;
        this.submitTime     = submitTime;
        this.CPUTime        = CPUTime;
        this.CPUTimeLeft    = CPUTime;
    }
    
    public void start(int sysTime) {
        startTime = sysTime;
    }
    
    public void tick(int sysTime) {
        CPUTimeLeft--;
        if (CPUTimeLeft <= 0){
            endTime = sysTime;
            evt.onFinish(this);
        }
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the submitTime
	 */
	public int getSubmitTime() {
		return submitTime;
	}

	/**
	 * @param submitTime the submitTime to set
	 */
	public void setSubmitTime(int submitTime) {
		this.submitTime = submitTime;
	}

	/**
	 * @return the cPUTime
	 */
	public int getCPUTime() {
		return CPUTime;
	}

	/**
	 * @param cPUTime the cPUTime to set
	 */
	public void setCPUTime(int cPUTime) {
		this.CPUTime = cPUTime;
	}

	/**
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the arrivalTime
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the cpuTime
	 */
	public int getCpuTime() {
		return cpuTime;
	}

	/**
	 * @param cpuTime the cpuTime to set
	 */
	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}

	/**
	 * @return the processId
	 */
	public int getProcessId() {
		return processId;
	}

	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(int processId) {
		this.processId = processId;
	}
    
}