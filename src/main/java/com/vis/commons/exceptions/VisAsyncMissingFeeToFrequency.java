package com.vis.commons.exceptions;

@SuppressWarnings("serial")
public class VisAsyncMissingFeeToFrequency extends RuntimeException {
	public VisAsyncMissingFeeToFrequency(String frequency) {
		super("It is missing the fee of frequency " + frequency);
	}
}
