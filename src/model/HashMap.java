package model;

public class HashMap<K,V> {
	  private int tableSize=50;
	  private NodeHash[] table;

	  public HashMap(){
	    table = new NodeHash[tableSize];
	    for(int i = 0; i < table.length; i++){
	      table[i] = null;
	    }
	  }

	  public V put(K key, V value){
	    int keyIndex = getHashCode(key);
	    if(table[keyIndex] == null){
	      table[keyIndex] = new NodeHash<K, V>(key, value);
	    }
	    else{
	      table[keyIndex] = new NodeHash<K, V>(key, value, table[keyIndex]);
	    }
	    return value;
	  }

	  public V get(K key){
	        int keyIndex = getHashCode(key);

	        if(table[keyIndex] == null){
	          return null;
	        }
	        else{
	          NodeHash<K,V> temp = table[keyIndex];          
	          while(temp != null){
	            if(temp.key.equals(key)){
	              return temp.value;
	            }
	            temp = temp.next;
	          }
	          return temp.value;
	        }

	      }
	  public int size(){
	      int size=0;
	      int i=0;
	      while(i<50){
	          if(table[i]==null){
	              i++;
	          }else{
	              size++;
	              i++;
	          }
	      }
	      return size;
	  }
	  public LinkedList keySet(){
	      int i=0;
	      LinkedList<K>a=new LinkedList();
	      while(i<50){
	          if(table[i]==null){
	              i++;
	          }else{
	              a.add((K)table[i].getKey());
	              i++;
	          }
	      }
	      return a;
	  }
	  public LinkedList values(){
	      int i=0;
	      LinkedList<V>a=new LinkedList();
	      
	      while(i<50){
	          if(table[i]==null){
	              i++;
	          }else{
	              
	              a.add((V)table[i].getValue());
	              i++;
	          }
	      }
	      return a;
	  }
	  public void clear() {
		  int i=0;
		  while(i<50) {
			  table[i]=null;
			  i++;
		  }
	  }
	  public boolean isEmpty(){
	       boolean flag=true;
	       int i=0;
	       while(i<50){
	           if(table[i]==null){
	               i++;
	           }else{
	               flag=false;
	               break;
	           }
	       }
	       return flag;
	   }
	  public boolean containsKey(K key){
	       boolean flag=false;
	       int i=0;
	       while(i<50) {
		if(table[i]==null) {
	            i++;
		}else {
		 if(table[i].getKey().equals(key)) {
			flag=true;
	                break;
		}
	         i++;
		}
			  }
			  return flag;
			  
		  }
	  public void remove(K key){
	      int i=0;
	      while(i<50){
	          if(table[i]==null){
	              i++;
	          }else{
	              if(table[i].getKey().equals(key)){
	                  table[i]=null;
	                  break;
	              }
	              i++;
	          }
	      }
	  }
	  public boolean containsValue(V value){
	       boolean flag=false;
	       int i=0;
	       while(i<50) {
		if(table[i]==null) {
	            i++;
		}else {
		 if(table[i].getValue().equals(value)) {
			flag=true;
	                break;
		}
	         i++;
		}
			  }
			  return flag;
			  
		  }
	  public int getHashCode(K key){
	    return key.hashCode() % tableSize;
	  }
	  
	}
	class NodeHash<K,V>{
	  public K key;
	  public V value;
	  public NodeHash next;

	  public NodeHash(K key, V value){
	    this(key, value, null);
	  }

	  public NodeHash(K key, V value, NodeHash next){
	    this.key = key;
	    this.value = value;
	    this.next = next;
	  }
	  public K getKey(){
	      return key;
	  }
	  public V getValue() {
		  return value;
	  }
	}
