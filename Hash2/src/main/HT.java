package main;

import java.util.Vector;

public class HT<K, V>
{

	private int size;
	private HashEntry<K, V>[] table;
	public HT(int size) {
		this.size = size;
		table = new HashEntry[size];
	}
	
	private static class HashEntry<K, V>
	{
		private K key;
		private Vector<V> value = new Vector<V>();
		private boolean wasDeleted = false;

		private HashEntry(K insertKey, V insertValue)
		{
			key = insertKey;
			value.add(insertValue);
		}
		
	}

	public boolean insertData(K key, V value){
		boolean found=false;
		for (int i = 0; i < size; ++i)
		{
			int pos = getPosition(key, i, size);
			if (table[pos] == null || table[pos].wasDeleted){
				table[pos] = new HashEntry<K, V>(key, value);
				found= true;
			}
			else if (table[pos].key.equals(key) && !table[pos].wasDeleted){
				table[pos].value.add(value);
				found= true;
			}
		}
		return found;
	}

	private int getPosition(K key, int i, int size){
		int newPos=(hash(key) + ((int) (Math.pow(i, 2) + i) >> 2)) % size;
		return newPos;
	}

	public Vector<V> findValue(K key){
		for (int i = 0; i < size; ++i){
			int pos = getPosition(key, i, size);
			if (table[pos] == null){
				return null;
			}
			else if (table[pos].key.equals(key) && !table[pos].wasDeleted){
				return table[pos].value;
			}
		}
		return null;
	}

	public boolean delete(K key){
		boolean found=false;
		for (int i = 0; i < size; ++i){
			int pos = getPosition(key, i, size);
			if (table[pos].key.equals(key) && !table[pos].wasDeleted)	{
				table[pos].wasDeleted = true;
				found= true;
			}
		}
		return found;
	}
	
	public int getLength() {
		return table.length;
	}
	public int hash(K key){
		String toHash = key.toString();
		int hashValue = 0;
		for (int pos = 0; pos < toHash.length(); ++pos){
			hashValue = (hashValue << 4) + toHash.charAt(pos);
			int highBits = hashValue & 0xF0000000;
			if (highBits != 0){
				hashValue ^= highBits >> 24;
			}
			hashValue &= ~highBits;
		}
		return hashValue;
	}
	
	/*public void debug()
	{
		float entriesPerSlot = (float) numEntries / (float) numFilledSlots;

		String result = "Format of display is\n";
		result += "Slot number: data record\n\n";
		result += "Current table size:\t\t\t\t\t\t" + table.length + "\n";
		result += "Number of elements in table:\t\t\t" + numEntries + "\n";
		result += "Number of filled slots in table:\t\t" + numFilledSlots + "\n";
		result += "Average number of entries per slot is:\t" + entriesPerSlot + "\n";
		System.out.println(result);

		for (int i = 0; i < table.length; i++)
		{
			// If the current slot has a value in it
			if (table[i] != null && !table[i].isTombstone)
			{
				// Store the key that it stores
				result = "\n" + i + ":\t" + ((i < 100) ? "\t" : "") + "[" + table[i].key.toString() + ", ";

				// Loop through all of the entries at that key
				for (V entry : table[i].value)
				{
					// Store the next value at that key
					result += "(" + entry.toString() + "), ";
				}

				result = result.substring(0, result.length() - 2) + "]";
				System.out.println(result);
			}
		}
	}*/
}