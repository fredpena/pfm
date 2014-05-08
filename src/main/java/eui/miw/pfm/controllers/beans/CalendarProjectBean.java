package eui.miw.pfm.controllers.beans;

import eui.miw.pfm.controllers.ejb.CalendarProjectEjb;
import eui.miw.pfm.models.entities.CalendarEntity;
import eui.miw.pfm.models.entities.ProjectEntity;
import eui.miw.pfm.util.SessionMap;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Manuel Álvarez
 * @code added Manuel Rodríguez
 */
@RequestScoped
@Named
public class CalendarProjectBean extends Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final CalendarEntity calendarEntity;
    private ProjectEntity project;
    private SessionMap sessionMap;
    private SimpleDateFormat format = new SimpleDateFormat("d/M/yy");
    private Date date1;
    private static final Logger LOG = Logger.getLogger(ConfProjectBean.class.getName());//NOPMD

    public CalendarProjectBean() {
        super();
        project = new ProjectEntity();
        calendarEntity = new CalendarEntity();
        this.sessionMap = new SessionMap();

        try {
            this.project = ((ProjectEntity) this.sessionMap.get("project"));
        } catch (Exception e) {
            LOG.warning("No session exist");
        }
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(final Date date1) {
        this.date1 = date1;
    }

    public String create() {
        this.calendarEntity.setProject(project);
        new CalendarProjectEjb().create(this.calendarEntity);
        return null;
    }

    public String update() {
        this.calendarEntity.setProject(project);
        new CalendarProjectEjb().update(this.calendarEntity);
        return null;
    }

    public String delete() {
        new CalendarProjectEjb().delete(this.calendarEntity);
        return null;
    }

    public String getStartDate() {
        return format.format(this.project.getStartDate());
    }

    public String getEndDate() {
        return format.format(this.project.getEndDate());
    }

    public int getWorkingDays() {
        final Calendar startDate;
        startDate = new GregorianCalendar();
        final Calendar endDate;
        endDate = new GregorianCalendar();
        startDate.setTime(this.project.getStartDate());
        endDate.setTime(this.project.getEndDate());
        int diffDays = 0;
        while (startDate.before(endDate) || startDate.equals(endDate)) {
            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                diffDays++;
            }
            startDate.add(Calendar.DATE, 1);
        }
        diffDays = diffDays - this.getRealHolidays();
        return diffDays;
    }

    public int getRealHolidays() {
        int count;
        count = 0;
        final CalendarProjectEjb ejb = new CalendarProjectEjb();
        for (CalendarEntity holiday : ejb.obtainHolidays(this.project)) {
            if (this.project.getStartDate().before(holiday.getHoliday().getTime()) && this.project.getEndDate().after(holiday.getHoliday().getTime())) {
                count++;
            }
        }
        return count;
    }

    public void handleDateSelect(final SelectEvent event) {
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.setTime(date1);
        CalendarEntity calendarentity;
        calendarentity = new CalendarEntity();
        calendarentity.setHoliday(calendar);
        calendarentity.setDescription("dd");
        calendarentity.setName("nn");
        calendarentity.setProject(project);
        new CalendarProjectEjb().create(calendarentity);
    }

    public String[] getHolidays() {
        CalendarProjectEjb calendarProjectEjb = new CalendarProjectEjb();
        List<CalendarEntity> holidays = calendarProjectEjb.obtainHolidays(project);
        String[] a = new String[holidays.size()];
        SimpleDateFormat formato = new SimpleDateFormat("MMMM d, yyyy", Locale.UK);
        for (int i = 0; i < holidays.size(); i++) {
            a[i] = "'" + formato.format(holidays.get(i).getHoliday().getTime()) + "'";
            System.out.println(a[i] + "-");
        }
        return a;
    }
}
