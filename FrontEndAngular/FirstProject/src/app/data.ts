import { Rata } from './rata';
import { ChartData } from './chart-data';

export class Data {
    public chartData: ChartData[];

    constructor(
        public odsetkiCalkowite: number,
        public sumaNadplat: number,
        public kwotaBazowa: number,
        public prowizja: number,
        public raty: Array<Rata>
    ) {
        this.chartData = [
            new ChartData(this.kwotaBazowa, 'Kwota'),
            new ChartData(this.odsetkiCalkowite, 'Odsetki'),
            new ChartData(this.sumaNadplat, 'Nadplata'),
            new ChartData(this.prowizja, 'Prowizja'),
          ];
    }
}
