package bikeShop;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Rental implements Serializable{

	private static final long serialVersionUID = -3280816519265694819L;
	private Customer rentee;
	private Item item;
	private int term;
	private Date timeOfRental;
	private Date timeItemIsDue;
	/**
	 * constant for the amount extra the customer is charged for returning the item late.
	 */
	public static final double LATECHARGE = 1.5;
	
	/**
	 * constructor for rental objects
	 * @param rentee person renting the item
	 * @param item the item being rented
	 * @param rentalTerm the specified term for the rental
	 * @param timeOfRental
	 */
	public Rental(Customer rentee, Item item, int rentalTerm, Date timeOfRental) {
		this.rentee = rentee;
		this.item = item;
		this.timeOfRental = timeOfRental;
		this.timeItemIsDue = addXDaysToTimeOfRental(rentalTerm);
		this.term = rentalTerm;
	}
	public Rental(Customer rentee, Item item, int rentalTerm) {
		this.rentee = rentee;
		this.item = item;
		this.timeOfRental = new Date();
		this.timeItemIsDue = addXDaysToTimeOfRental(rentalTerm);
		this.term = rentalTerm;
	}
	private long getDateDifference(Date startDate, Date endDate)
	{
		return TimeUnit.DAYS.convert(startDate.getTime()-endDate.getTime(), TimeUnit.MILLISECONDS);
	}
	public double getRentalCost()
	{
		return this.term * this.item.getDailyRentalFee();
	}
	/**
	 * returns the amount the customer owes for the rental.
	 * @return the amount owed.
	 */
	public double getAmountOwed()
	{
		int amountDue = 0;
		if(isOverdue())
		{
			amountDue += LATECHARGE*getRentalCost()*getDateDifference(this.timeItemIsDue, new Date());
		}
		return amountDue;
		
	}
	/**
	 * 
	 * @return true if the item is overdue
	 */
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
	public Date getDueDate()
	{
		return this.timeItemIsDue;
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
	public String toString()
	{
		return this.item.toString();
	}
	
}
