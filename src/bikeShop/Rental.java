package bikeShop;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Rental implements Serializable{

	private static final long serialVersionUID = -3280816519265694819L;
	private Customer rentee;
	private Item item;
	private Date timeOfRental;
	private Date timeItemIsDue;
	public Rental(Customer rentee, Item item, int rentalTerm, Date timeOfRental) {
		this.rentee = rentee;
		this.item = item;
		this.timeOfRental = timeOfRental;
		this.timeItemIsDue = addXDaysToTimeOfRental(rentalTerm);
	}
	private long getDateDifference(Date startDate, Date endDate)
	{
		return TimeUnit.DAYS.convert(startDate.getTime()-endDate.getTime(), TimeUnit.MILLISECONDS);
	}
	public double getAmountOwed()
	{
		double rate = item.getDailyRentalFee();
		long timeSinceRented = getDateDifference(timeOfRental, new Date());
		double amountDue = timeSinceRented * rate;
		if(isOverdue())
		{
			amountDue *= 1.5; //50% late fee
		}
		return amountDue;
		
	}
	public boolean isOverdue()
	{
		return timeItemIsDue.before(new Date());
	}
	private Date addXDaysToTimeOfRental(int numDaysToAdd)
	{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeOfRental);
        calendar.add(Calendar.DATE, numDaysToAdd);
        return calendar.getTime();
	}
	public Customer getRentee() {
		return rentee;
	}
	public void setRentee(Customer rentee) {
		this.rentee = rentee;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Date getTimeOfRental() {
		return timeOfRental;
	}
	public void setTimeOfRental(Date timeOfRental) {
		this.timeOfRental = timeOfRental;
	}
	
}
