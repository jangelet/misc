function countDuplicates(numbers) {
    
    if(numbers == null) return 0;
    
    //O(n) time solution
    //dictionary that counts occurances of integers in input array
    var tracker = {};
    //result int var that counts every
    var result = 0;
    
    //iterate through input array, add to tracker with arr element as key, # occurances as value
    numbers.forEach(function(index) {
        tracker[index] = (tracker[index] || 0) + 1;
        //only increment result when a duplicate is found
        //elements that appear more than twice are disregarded
        if(tracker[index] === 2){
            result++;
        }
    })
    
    return result;

}

