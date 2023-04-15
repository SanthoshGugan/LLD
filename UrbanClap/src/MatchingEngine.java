import model.Appointment;
import service.AdminService;

import java.util.concurrent.*;

public class MatchingEngine {

    private AdminService adminService;
    private ExecutorService executorService;

    public MatchingEngine(final AdminService adminService) {
        this.adminService = adminService;
        executorService = Executors.newFixedThreadPool(1);
    }

    private class RequestCallable implements Callable<Appointment> {
        private Appointment appointment;

        public RequestCallable(final Appointment appointment) {
            this.appointment = appointment;
        }

        public Appointment call() {
            return adminService.searchAndMatchAppointment(appointment);
        }
    }

    public Appointment match(final Appointment appointment) throws ExecutionException, InterruptedException {
        final Future appointmentFuture = executorService.submit(new RequestCallable(appointment));
        final Appointment updatedAppointment = (Appointment) appointmentFuture.get();
        return updatedAppointment;
    }

    public void exit() {
        executorService.shutdown();
    }

}

