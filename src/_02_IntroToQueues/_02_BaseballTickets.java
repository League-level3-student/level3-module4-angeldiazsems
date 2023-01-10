/*
 * Copyright (c) 2020, <GiacomoSorbi> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _02_IntroToQueues;

import java.util.ArrayDeque;

/*
 * Complete the calculateWaitTime() method here!
 * Instructions are in the BaseBallTicketsTest class.
 */

public class _02_BaseballTickets {

    public static int calculateWaitTime( ArrayDeque<Integer> ticketsQueue, int position ) {
    	int minutes = 0;
		int value = 0;

		ArrayDeque<Integer> copy = ticketsQueue.clone();
		for (int i = 0; i <= position; i++) { // looking for value at given position
			value = copy.remove();
			if (i == position) {
				break;
			}

		}
		System.out.println("");
		System.out.println("------------------------------------------------------------");
		System.out.println("");
		int subtracted = 0;
		while (value != 0) {
			
			System.out.println("Old :" + ticketsQueue);
			
			int removed = ticketsQueue.remove();

			if (removed == value && position == 0) {
				value = value - 1;
				subtracted = value;
				
				int size = ticketsQueue.size();
				position = size;
				
			} else {
				subtracted = removed - 1;
				position--;
			}

			if (subtracted > 0) {
				ticketsQueue.add(subtracted);
				minutes++;
				System.out.println("New: " + ticketsQueue);
				System.out.println("Target: " + value);
				System.out.println("target is at position: "+position);
				System.out.println("Minutes taken: "+minutes);
				System.out.println("");

			} else {
				minutes++;
				System.out.println("New:" + ticketsQueue);
				System.out.println("Minutes taken: "+minutes);
				System.out.println("");
			}

		}

		return minutes;
    }
}
